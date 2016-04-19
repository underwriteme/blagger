package blagger

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TagController)
class TagControllerSpec extends Specification {

    void "list of tags is rendered based on the given stem"() {
        given:
        params.stem = "test"

        when:
        controller.list()

        then:
        response.json == ['test0', 'test1', 'test2', 'test3', 'test4']
    }
}