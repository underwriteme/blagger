package blagger

import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PostController)
@Mock(Post)
class PostControllerSpec extends spock.lang.Specification {

    def 'list returns the blag posts'(){
        given:
        new Post(title: 'test', email: 'test@test.com', content: 'test').save()

        when:
        def model = controller.index()

        then:
        model.posts
        model.posts[0].title == 'test'
    }

    def 'list returns the blag posts in the correct order'(){
        given:
        new Post(title: 'test1', email: 'test@test.com', content: 'test').save()
        new Post(title: 'test2', email: 'test@test.com', content: 'test').save()

        when:
        def model = controller.index()

        then:
        model.posts
        model.posts[0].title == 'test2'
    }


    def 'create adds a new blag post and redirects'() {
        given:
        controller.params.title = 'test'
        controller.params.email = 'test@test.com'
        controller.params.content = 'test'

        when:
        controller.savePost()
        def posts = Post.list()

        then:
        posts
        posts[0].title == 'test'
        posts[0].email == 'test@test.com'
        posts[0].content == 'test'
        response.redirectUrl.endsWith('/index')
    }

}
