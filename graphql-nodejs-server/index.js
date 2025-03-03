const express = require('express');
const { ApolloServer, gql } = require('apollo-server-express');

const app = express();
const port = 8081;

const typeDefs = gql`
    type Query {
        hello: String!
    }
`
const resolvers = {
    Query: {
        hello: () => 'Hello Goopang Graphql World!'
    }
}

async function startServer() {
    const server = new ApolloServer({ typeDefs, resolvers});
    await server.start();
    server.applyMiddleware({ app });
    
    app.listen(port, () => {
        console.log(`Server is running at http://localhost:${port}${server.graphqlPath}`);
    })
}

startServer();