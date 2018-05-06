package contracts

import org.springframework.cloud.contract.spec.Contract
/**
 * Created by Jakub Krhovják on 5/6/18.
 *
 */

Contract.make {
    description "should return service name"
    request {
        method GET()
        url("/restCall") {

        }
    }
    response {
        body("/restCall-get")
        status 200
    }
}

