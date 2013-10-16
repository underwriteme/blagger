package blagger

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(BlogController)
@Mock(Post)
class BlogControllerSpec extends spock.lang.Specification {

    def 'List returns the blag posts'() {

        setup:
        new Post(title: 'test', email: 'test@test.com', content: 'test').save()

        and:
        def model = controller.list()

        expect:
        model.posts
        model.posts[0].title == 'test'
    }

    def 'Validation errors are returned for invalid fields'() {

        setup:
        def post = new Post(title: 'IV', email: 'INVALID', content: '')
        post.validate()

        expect:
        post.errors
        post.errors.getErrorCount() == 3
        post.errors.fieldErrors[0].field == 'title'
        post.errors.fieldErrors[1].field == 'email'
        post.errors.fieldErrors[2].field == 'content'
    }


    def 'List returns the blag posts in the correct order'() {

        setup:
        new Post(title: 'test1', email: 'test@test.com', content: 'test').save()
        new Post(title: 'test2', email: 'test@test.com', content: 'test').save()

        and:
        def model = controller.list()

        expect:
        model.posts
        model.posts[0].title == 'test2'
    }

    def 'Paged List returns the blag posts in the correct order'() {

        setup:
        new Post(title: 'test1', email: 'test@test.com', content: 'test').save()
        new Post(title: 'test2', email: 'test@test.com', content: 'test').save()

        and:
        def model = controller.listPaged()

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
