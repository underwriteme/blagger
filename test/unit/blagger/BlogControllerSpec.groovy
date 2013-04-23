package blagger

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(BlogController)
@Mock(Post)
class BlogControllerSpec extends spock.lang.Specification {

    def 'List returns the blag posts'(){

        setup:
            new Post(title: 'test', email: 'test@test.com', content: 'test').save()

        and:
            def model = controller.list()

        expect:
            model.posts
            model.posts[0].title == 'test'
    }


    def 'List returns the blag posts in the correct order'(){

        setup:
            new Post(title: 'test1', email: 'test@test.com', content: 'test').save()
            new Post(title: 'test2', email: 'test@test.com', content: 'test').save()

        and:
            def model = controller.list()

        expect:
            model.posts
            model.posts[0].title == 'test2'
    }


    def 'Create adds a new blag post and redirects'() {

        setup:
            controller.params.title = 'test'
            controller.params.email = 'test@test.com'
            controller.params.content = 'test'

        when:
            controller.createPost()
            def posts = Post.list()

        then:
            posts
            posts[0].title == 'test'
            posts[0].email == 'test@test.com'
            posts[0].content == 'test'
            response.redirectUrl.endsWith('/list')
    }

}
