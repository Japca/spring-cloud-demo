package contracts

import org.springframework.cloud.contract.spec.Contract

/**
 * Created by Jakub Krhovják on 5/7/18.
 *
 */
Contract.make {
    description "should service name"
    request {
        method POST()
        url("/receive") {
            headers {
                header 'Content-Type': 'application/json'
            }
            body([
                    name: "Test name",
                    age: 23
            ])
        }
    }
    response {
        body("/receivePost-post")
        status 200
    }
}