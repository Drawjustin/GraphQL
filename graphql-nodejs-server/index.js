const express = require('express');
const { ApolloServer, gql } = require('apollo-server-express');
const fs = require('fs').promises;

const app = express();
const port = 8081;

const schemaFiles = [
    // './schemas/custom-scalar.graphql',
    './schemas/query.graphql',
    './schemas/mutation.graphql',
    './schemas/subscription.graphql',
    './schemas/product.graphql',
    './schemas/user.graphql',
    './schemas/cart.graphql'
  ];

const typeDefs = gql`
    type Query {
        hello: String!
    }
`
const resolvers = {

}

async function startServer() {
    const schmeas = await Promise.all(
        schemaFiles.map(file => fs.readFile(file, 'utf-8'))
    );

    const server = new ApolloServer({ typeDefs: schmeas, resolvers});
    await server.start();
    server.applyMiddleware({ app });
    
    app.listen(port, () => {
        console.log(`Server is running at http://localhost:${port}${server.graphqlPath}`);
    })
}

startServer();