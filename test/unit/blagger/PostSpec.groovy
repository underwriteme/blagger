package blagger

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Post)
@Unroll
class PostSpec extends Specification {

    def post = new Post(title: 'Title', email: 'test@test.com', content: 'Content', tag: 'Tag')

    void 'should successfully validate post'() {
        expect:
        post.validate()
    }

    void 'should be invalid if title with less than 3 characters is provided'() {
        given:
        post.title = invalidTitle

        expect:
        !post.validate()

        where:
        invalidTitle << [null, '', 'Ti']
    }

    void 'should be invalid if valid email is not provided'() {
        given:
        post.email = invalidEmail

        expect:
        !post.validate()

        where:
        invalidEmail << [null, '', 'test@']
    }

    void 'should be invalid if content is not provided'() {
        given:
        post.content = invalidContent

        expect:
        !post.validate()

        where:
        invalidContent << [null, '']
    }
    
    void 'should be invalid if tag is not provided'() {
        given:
        post.tag = invalidTag

        expect:
        !post.validate()

        where:
        invalidTag << [null, '']
    }
    
    void 'tag can have a maximum of 20 characters'() {
    when: 'for a string of 21 characters'
    String str = 'x' * 21
    domain.tag = str

    then: 'tag validation fails'
    !domain.validate(['tag'])
    domain.errors['tag'].code == 'maxSize.exceeded'

    when: 'for a string of 19 characters'
    str = 'x' * 19
    domain.tag = str

    then: 'tag validation passes'
    domain.validate(['tag'])
	}
}
