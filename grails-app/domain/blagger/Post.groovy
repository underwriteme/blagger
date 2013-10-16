package blagger

class Post {

    String title
    String email
    String content
    Tag tag
    Date dateCreated
    Date lastUpdated

    static constraints = {
        title blank: false, minSize: 3
        email email: true
        content blank: false
        tag(nullable: true)
    }

    static mapping = {
        content type: 'text'
        sort id: "desc"
    }

}
