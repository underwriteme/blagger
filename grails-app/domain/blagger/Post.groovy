package blagger

class Post {

    String title
    String email
    String content
    Date dateCreated
    Date lastUpdated
	String category

    static constraints = {
		title    blank: false, minSize: 3
		email    blank: false, email: true
		content  blank: false
		category blank: false
    }

    static mapping = {
        content type: 'text'
    }

}
