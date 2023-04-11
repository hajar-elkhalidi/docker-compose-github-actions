# Docker Compose Example for GitHub Actions

This repository provides an example of how to use Docker Compose to run and test a Spring Boot API in GitHub Actions. The API provides basic CRUD operations for managing client data, and the tests are written in robotframework.

## Continuous Integration

[![.github/workflows/test.yml](https://github.com/hajar-elkhalidi/docker-compose-github-actions/actions/workflows/test.yml/badge.svg)](https://github.com/hajar-elkhalidi/docker-compose-github-actions/actions/workflows/test.yml)

## Usage

To use this example, follow these steps:

1. Fork this repository to your own GitHub account.
1. Clone the repository to your local machine.
1. Build the Docker images for the API and the DB.
1. Start the Docker containers by running `docker-compose up -d`.
1. Run the tests by running `robot tests.robot`.
1. Stop the Docker containers by running `docker-compose down`.

## GitHub Actions Workflow

This repository includes a GitHub Actions workflow that runs the Docker Compose commands to run and test the API whenever changes are pushed to the main branch. The workflow is defined in the .github/workflows/test.yml file.

## API Endpoints

The API provides the following endpoints:

* GET /api/v1/clients - Returns a list of all clients.
* GET /api/v1/clients/{id} - Returns the client with the specified ID.
* POST /api/v1/clients - Adds a new client.
* PUT /api/v1/clients/{id} - Updates the client with the specified ID.
* DELETE /api/v1/clients/{id} - Deletes the client with the specified ID.

## Configuration

Please update the following:

When running locally:

* Update the image names of the API and the database in the compose.yaml file.
* Ensure that Robot Framework is installed.

And in GitHub Actions:

* Please update the variables used to login to ghcr.io.
