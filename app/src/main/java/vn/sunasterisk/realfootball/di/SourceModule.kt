package vn.sunasterisk.realfootball.di

import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import vn.sunasterisk.realfootball.FootballApplication
import vn.sunasterisk.realfootball.base.ContextProviders
import vn.sunasterisk.realfootball.data.local.FootBallDb
import vn.sunasterisk.realfootball.data.repository.HighlightRepository
import vn.sunasterisk.realfootball.data.repository.MatchRepository
import vn.sunasterisk.realfootball.data.repository.PlayerRepository
import vn.sunasterisk.realfootball.data.repository.TeamRepository
import vn.sunasterisk.realfootball.ui.detailmatch.DetailViewModel
import vn.sunasterisk.realfootball.ui.highlight.HighlightViewModel
import vn.sunasterisk.realfootball.ui.match.MatchViewModel
import vn.sunasterisk.realfootball.ui.playerdetail.DetailPlayerViewModel
import vn.sunasterisk.realfootball.ui.search.SearchPlayerViewModel
import vn.sunasterisk.realfootball.ui.team.TeamViewModel
import vn.sunasterisk.realfootball.ui.teamdetail.DetailTeamViewModel

val sourceModule = module {
    single { ContextProviders() }
    single { FootBallDb.getDatabase().matchDao() }
    single { FootBallDb.getDatabase().playerDao() }
    single { FootBallDb.getDatabase().teamDao() }
    single { FootBallDb.getDatabase().highlightDao() }
    single { MatchRepository(get(), get(named(RemoteProperties::class.java.name)), get()) }
    single { TeamRepository(get(), get(named(RemoteProperties::class.java.name)), get()) }
    single { PlayerRepository(get(), get(named(RemoteProperties::class.java.name)), get()) }
    single { HighlightRepository(get(), get(named(RemoteHighlight::class.java.name)), get()) }
}
val viewModelModule = module {
    single(named(FootballApplication::class.java.name)) { androidApplication() }
    viewModel { MatchViewModel(get(named(FootballApplication::class.java.name)), get()) }
    viewModel { DetailViewModel(get(named(FootballApplication::class.java.name)), get(), get()) }
    viewModel { TeamViewModel(get(named(FootballApplication::class.java.name)), get()) }
    viewModel { DetailTeamViewModel(get(named(FootballApplication::class.java.name))) }
    viewModel { SearchPlayerViewModel(get(named(FootballApplication::class.java.name)), get()) }
    viewModel { DetailPlayerViewModel(get(named(FootballApplication::class.java.name))) }
    viewModel { HighlightViewModel(get(named(FootballApplication::class.java.name)), get()) }
}
