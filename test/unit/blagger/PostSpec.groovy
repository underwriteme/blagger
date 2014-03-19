package blagger;

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Post)
public class PostSpec extends Specification {

	@Unroll
	def 'Creating a post when the title is #title'() {
		when: 'a new post is created'
		def p = new Post(title: title, email: "test@test.com", content: "SOME_CONTENT")

		then: 'the post is validated'
		p.validate() == shouldPass

		where:
		title  | shouldPass
		null   | false
		''     | false
		'A'    | false
		'AB'   | false
		'ABC'  | true
		'ABCD' | true
	}
	
	def 'Test that the email is validated correctly'() {
		when: 'the email is invalid'
		def p = new Post(title: "SOME_TITLE", email: "SOME_EMAIL", content: "SOME_CONTENT")
		
		then: 'validation should fail'
		!p.validate()
		
		when: 'the email is valid'
		p = new Post(title: "SOME_TITLE", email: "test@test.com", content: "SOME_CONTENT")
		
		then: 'validation should pass'
		p.validate()
	}
}
