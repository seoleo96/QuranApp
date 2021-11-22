package com.example.quranapp.core


import android.app.Application
import com.example.quranapp.data.chapters.QuranCloudMapper
import com.example.quranapp.data.chapters.QuranRepositoryImpl
import com.example.quranapp.data.chapters.local.QuranCacheDataSource
import com.example.quranapp.data.chapters.local.QuranDb
import com.example.quranapp.data.chapters.net.QuranCloudDataSource
import com.example.quranapp.data.chapters.net.QuranDataMapper
import com.example.quranapp.data.chapters.net.ChaptersService
import com.example.quranapp.data.contents.ContentCloudMapper
import com.example.quranapp.data.contents.ContentRepositoryImpl
import com.example.quranapp.data.contents.net.ContentCloudDataSource
import com.example.quranapp.data.contents.net.ContentDataMapper
import com.example.quranapp.data.contents.net.ContentsService
import com.example.quranapp.data.retrofit.RetrofitInstance
import com.example.quranapp.domain.chapters.Interactor
import com.example.quranapp.domain.chapters.QuranDataModelToDomainMapperImpl
import com.example.quranapp.domain.chapters.QuranDomainMapperImpl
import com.example.quranapp.domain.contents.ContentDataModelToDomainMapperImpl
import com.example.quranapp.domain.contents.ContentDomainMapperImpl
import com.example.quranapp.domain.contents.InteractorContents
import com.example.quranapp.ui.chapters.QuranCommunication
import com.example.quranapp.ui.chapters.QuranUIMapperImpl
import com.example.quranapp.ui.chapters.QuranUIStateMapperImpl
import com.example.quranapp.ui.contents.ContentCommunication
import com.example.quranapp.ui.contents.ContentUIMapperImpl
import com.example.quranapp.ui.contents.ContentUIStateMapperImpl
import com.example.quranapp.ui.contents.ContentViewModel
import com.example.quranapp.ui.home.HomeViewModel


class App : Application() {

    lateinit var homeViewModel: HomeViewModel
    lateinit var contentViewModel: ContentViewModel
    override fun onCreate() {
        super.onCreate()

        val service: ChaptersService = RetrofitInstance().service
        val quranCloudDataSource = QuranCloudDataSource.Base(service)
        val quranDataMapper = QuranDataMapper.Base()
        val quranCloudMapper = QuranCloudMapper.Base(quranDataMapper = quranDataMapper)
        val db = QuranDb.getDatabase(this.applicationContext)
        val dao = db.covidDao()
        val cacheDataSource = QuranCacheDataSource.Base(dao)
        val quranRepository =
            QuranRepositoryImpl(cloudDataSource = quranCloudDataSource, cloudMapper = quranCloudMapper, cacheDataSource = cacheDataSource)
        val quranDataModelToDomainMapper = QuranDataModelToDomainMapperImpl()
        val quranDomainMapper =
            QuranDomainMapperImpl(quranDataModelToDomainMapper = quranDataModelToDomainMapper)
        val interactor =
            Interactor.Base(repository = quranRepository, quranDomainMapper = quranDomainMapper)
        val quranUIStateMapper = QuranUIStateMapperImpl()
        val quranUIMapper = QuranUIMapperImpl(quranUIStateMapper = quranUIStateMapper)
        val quranCommunication = QuranCommunication.Base()
        homeViewModel = HomeViewModel(interactor = interactor,
            quranUiMapper = quranUIMapper,
            quranCommunication = quranCommunication)

        val serviceContent: ContentsService = RetrofitInstance().contentService
        val contentCloudDataSource = ContentCloudDataSource.Base(serviceContent)
        val contentDataMapper = ContentDataMapper.Base()
        val contentCloudMapper = ContentCloudMapper.Base(contentDataMapper = contentDataMapper)
//        val db = QuranDb.getDatabase(this.applicationContext)
//        val dao = db.covidDao()
//        val cacheDataSource = QuranCacheDataSource.Base(dao)
        val contentRepository =
            ContentRepositoryImpl(cloudDataSource = contentCloudDataSource, cloudMapper = contentCloudMapper)
        val contentDataModelToDomainMapper = ContentDataModelToDomainMapperImpl()
        val contentDomainMapper =
            ContentDomainMapperImpl(contentDataModelToDomainMapper = contentDataModelToDomainMapper)
        val interactorContent =
            InteractorContents.Base(repository = contentRepository, contentDomainMapper = contentDomainMapper)
        val contentUIStateMapper: ContentUIStateMapperImpl = ContentUIStateMapperImpl()
        val contentUIMapper = ContentUIMapperImpl(contentUIStateMapper = contentUIStateMapper)
        val contentCommunication = ContentCommunication.Base()
        contentViewModel = ContentViewModel(interactor = interactorContent,
            contentUiMapper = contentUIMapper,
            contentCommunication = contentCommunication)

    }

}