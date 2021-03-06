import blagger.Post

class BootStrap {

    def init = { servletContext ->

        def content = """\
        <dl>
            <dt>Add the ability to create tags on new blag posts</dt>
            <dd>
                <ol>
                    <li>Add the ability to add a single tag to a new blag post. (For instance, tagging a particular post that it relates to "programming")</li>
                    <li>Use a typeahead control to suggest existing tags once at least 3 characters have been entered</li>
                    <li>Allow the filtering of blag posts by tag on the home page</li>
                </ol>
            </dd>
        </dl>
        """

        Post post = new Post(title: 'Your challenge if you choose to accept it...', email: 'info@underwriteme.co.uk', content: content)
        post.save()

    }
    def destroy = {
    }
}
