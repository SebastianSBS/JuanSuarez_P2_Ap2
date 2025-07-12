package com.example.juansuarez_p2_ap2.data.remote

import com.example.juansuarez_p2_ap2.data.remote.dto.ContributorsDto

interface ContributorsApi {
    @retrofit2.http.GET("repos/enelramon/DemoAp2/contributors")
    @retrofit2.http.Headers("X-API-Key: test")
    suspend fun getContributors():List<ContributorsDto>
}
