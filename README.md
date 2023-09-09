# Beers Test

This is a code test using the Beers API api at [random-data-api](https://random-data-api.com/api/v2/beers).


The app is divided in three modules: **app**, **domain** and **data**


## Data module

The Data module is in charge of querying the Beers API. Since this code test doesn't implement any kind of online behavior, it just uses Retrofit to query the API.

The Data module has no access to the domain or app modules.

## Domain module

The Domain module is in charge of transforming the raw data from the Data module into something the App module can use. It defines both the use cases (in this case there's just one, but additional use cases would go here) and a mapper that turns the raw response into our model.

The [UseCases](https://github.com/diamonddudetcg/beers-test/blob/main/domain/src/main/java/com/santirivera/domain/usecase/BaseUseCase.kt) use Kotlin Corroutines to handle asynchronicity. They're defined as simple operations with an input and an output that is returned via a callback (if provided). The App module simply injects these use cases and defines callbacks for the output. In case no callback is provided, the operation is completed silently.

The Domain module has access to the Data module, but not the App module

## App module

The App module is where all the Android components go. The UI, Application, Activity and Fragment goes here.

It uses a MVVM architecture (although a pretty basic one considering the small functionality of this code test).

[Dependency injection](https://github.com/diamonddudetcg/beers-test/tree/main/app/src/main/java/com/santirivera/frogtekbeertest/di) is handled using Hilt.

The meat of the app is in the [FrogtekBeerListFragment](https://github.com/diamonddudetcg/beers-test/blob/main/app/src/main/java/com/santirivera/frogtekbeertest/fragment/list/FrogtekBeerListFragment.kt). It extends [FrogtekBeerBaseFragment](https://github.com/diamonddudetcg/beers-test/blob/main/app/src/main/java/com/santirivera/frogtekbeertest/fragment/base/FrogtekBeerBaseFragment.kt), which implements behavior for displaying a Dialog while the content is loading, hiding it once the content is loaded, and displaying the No Internet error. These behaviors are defined in the [Loadable](https://github.com/diamonddudetcg/beers-test/blob/main/app/src/main/java/com/santirivera/frogtekbeertest/fragment/base/Loadable.kt) interface.

This fragment is responsible for displaying the list queried by the [ViewModel](https://github.com/diamonddudetcg/beers-test/blob/main/app/src/main/java/com/santirivera/frogtekbeertest/fragment/list/FrogtekBeerListViewModel.kt), and also display a [FrogtekBeerDialog](https://github.com/diamonddudetcg/beers-test/blob/main/app/src/main/java/com/santirivera/frogtekbeertest/fragment/list/FrogtekBeerDialog.kt) when one of the items is clicked on, which displays the entire data for each beer.
