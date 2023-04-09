package com.test.rxjava

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.async.DeferredResult
import java.util.*


@RestController
class TestController {
    @PostMapping("/post")
    fun postWithMsg(@RequestBody dto: TestDTO):  DeferredResult<String> {
        val deferredResult: DeferredResult<String> = DeferredResult()

        Observable.just(dto.msg)
            .map { s -> {
                for (i in 0..100) {
                    Thread.sleep(100)
                    println("${Thread.currentThread().name}: $i - test: ${s.uppercase(Locale.getDefault())}")
                }
            } }
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result -> deferredResult.setResult("ok") }
            ) { error -> deferredResult.setResult("error") }

        return deferredResult;
    }
}

data class TestDTO(val msg: String)
