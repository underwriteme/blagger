package blagger

import grails.test.mixin.*
import spock.lang.Specification

@TestFor(PostController)
@Mock(Post)
class PostControllerSpec extends Specification {

    def 'list returns the blag posts'(){
        given:
        new Post(title: 'test', email: 'test@test.com', content: 'test', tag: 'test').save()

        when:
        def model = controller.index()

        then:
        model.posts
        model.posts[0].title == 'test'
    }

    def 'list returns the blag posts in the correct order'(){
        given:
        new Post(title: 'test1', email: 'test@test.com', content: 'test', tag: 'test').save()
        new Post(title: 'test2', email: 'test@test.com', content: 'test', tag: 'test').save()

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
        controller.params.tag = 'test'

        when:
        controller.savePost()
        def posts = Post.list()

        then:
        posts
        posts[0].title == 'test'
        posts[0].email == 'test@test.com'
        posts[0].content == 'test'
        posts[0].tag == 'test'
        response.redirectUrl.endsWith('/index')
    }

    def 'invalid post is not saved and create page is rendered with the errors'() {
        given:
        controller.params.title = ''
        controller.params.email = 'test@test.com'
        controller.params.content = 'test'
        controller.params.tag = 'test'

        when:
        controller.savePost()

        then:
        !Post.count

        and:
        with (controller.modelAndView) {
            viewName == '/post/create'
            model.post.hasErrors()
        }
    }
    
    def 'create a new blag post with given tag and redirects'() {
        given:
        controller.params.title = 'test'
        controller.params.email = 'test@test.com'
        controller.params.content = 'test'
        controller.params.tag = 'test'

        when:
        controller.savePost()
        def posts = Post.list()

        then:
        posts
        posts[0].title == 'test'
        posts[0].email == 'test@test.com'
        posts[0].content == 'test'
        posts[0].tag == 'test'
        response.redirectUrl.endsWith('/index')
    }
    
     def 'create a new blag post with given tag and call indexByTag '() {
        given:
        controller.params.title = 'test'
        controller.params.email = 'test@test.com'
        controller.params.content = 'test'
        controller.params.tag = 'test'

        when:
        controller.savePost()
        controller.indexByTag()

        then:
        response.redirectUrl.endsWith('/index')
    }
    
}
