<div id="searchresults">

    <g:if test="${searchresults}">
    
    
		<ul id="typeAheadList" style="list-style-type: none; padding: 0; margin: 0; display: inline;">
		<g:each in="${searchresults}" status="loop" var="postInstance">
		
		
		  <li class="selected" tabIndex="0" id="litag${postInstance.id}">
		  <a style="display: block; border: 1px solid #ddd; margin-top: -1px; background-color: #f6f6f6; 
		  padding: 1px; text-decoration: none; font-size: 14px;display: block;" id="atag${postInstance.id}" href="#" 
		  onclick="fnSelectTag(event, this.id, true)">
		  ${fieldValue(bean: postInstance, field: "tag")}</a></li>
		</g:each>	
		</ul>
    

        
    </g:if>
</div>