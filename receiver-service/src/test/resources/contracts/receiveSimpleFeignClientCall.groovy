package contracts

import org.springframework.cloud.contract.spec.Contract

/**
 * Created by Jakub Krhovják on 5/6/18.
 *
 */
Contract.make {
    description "should service name"
    request {
        method GET()
        url("/receive") {

        }
    }
    response {
        body("receive-service")
        status 200
    }
}