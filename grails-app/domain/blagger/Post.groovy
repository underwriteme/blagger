package blagger

class Post {

    String title
    String email
    String content
    Date dateCreated
    Date lastUpdated

    static constraints = {
		title    blank: false, minSize: 3
		email    blank: false, email: true
		content  blank: false
    }

    static mapping = {
        content type: 'text'
    }

}
