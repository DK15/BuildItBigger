package com.udacity.gradle.builditbigger.backend;

import com.example.darshan.javajokelibrary.Joke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */

    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke() {
        MyBean result = new MyBean();
        Joke joke = new Joke();
        result.setData(joke.tellJoke());
        return result;
    }
}
