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
	
	@Unroll
	def 'Test creating a post when the email is #email'() {
		when: 'a new post is created'
		def p = new Post(title: "SOME_TITLE", email: email, content: "SOME_CONTENT")
		
		then: 'the post is validated'
		p.validate() == shouldPass
		
		where:
		email           | shouldPass
		null            | false
		''              | false
		'SOME_EMAIL'    | false
		'test@test.com' | true
	}
	
	@Unroll
	def 'Tests creating a post when the content is #content'() {
		when: 'a new post is created'
		def p = new Post(title: "SOME_TITLE", email: "test@test.com", content: content)
		
		then: 'the post is validated'
		p.validate() == shouldPass
		
		where:
		content | shouldPass
		null    | false
		''      | false
		'A'     | true
		'AB'    | true
	}
}
