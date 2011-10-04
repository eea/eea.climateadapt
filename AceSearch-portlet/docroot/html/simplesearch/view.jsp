<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<portlet:defineObjects />

<script type="text/javascript">
    function GetKey (event){
        var keyCode = ('which' in event) ? event.which : event.keyCode;
        if(keyCode==13) {
        	document.location.href='/data-and-downloads?searchtext=' + document.getElementById('searchtext').value; 
        	document.getElementById('searchtext').value='';
        }
    }
</script>
<input id="searchtext" name="searchtext" type="text" onkeydown="GetKey(event)" >
&nbsp;<img src="<%= request.getContextPath() %>/images/vergrootglas.png"  onClick="document.location.href='/data-and-downloads?searchtext=' + document.getElementById('searchtext').value; document.getElementById('searchtext').value='';">
