package blagger;

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Post)
public class PostSpec extends Specification {

	@Unroll
	def 'Creating a post when the title is #title'() {
		when: 'the title is not given'
		def p = new Post(title: title, email: "SOME_EMAIL", content: "SOME_CONTENT")

		then: 'validation should fail'
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
}
