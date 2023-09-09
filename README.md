# Beers Test

This is a code test using the Beers API api at [random-data-api](https://random-data-api.com/api/v2/beers).


The app is divided in three modules: **app**, **domain** and **data**


## Data module

The Data module is in charge of querying the Beers API. Since this code test doesn't implement any kind of online behavior, it just uses Retrofit to query the API.

The Data module has no access to the domain or app modules.

## Domain module

The Domain module is in charge of transforming the raw data from the Data module into something the App module can use. It defines both the use cases (in this case there's just one, but additional use cases would go here) and a mapper that turns the raw response into our model.
