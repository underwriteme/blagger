import blagger.Post

class BootStrap {

    def init = { servletContext ->

        def content = """\
        
        1. Tag has been added as mandatory input field.
        2. Upon typing 3 character in the Tag field the typeahead list will be displayed. Use mouse or up-down-enter key as appropiate.
        3. Post filtering funtion has been added to homepage. Tag is shown at the right hand side - upon clicking this tag, filtered list will be displayed.
        
        I have tested with several live posts from twitter, linkedIN, facebook with random tags and result is displayed as expected. 
        However I would be happy to incorporate review comment as required. 
        
        I have not added any angular or ReST service as that would require changes in the framework itself. 
        Again I would be happy to do so if needed. Thank You.     
        
        """

        Post post = new Post(title: 'The given challenge has been completed!', email: 'info@underwriteme.co.uk', content: content, tag: '#sampleTag')
        post.save()

    }
    def destroy = {
    }
}
