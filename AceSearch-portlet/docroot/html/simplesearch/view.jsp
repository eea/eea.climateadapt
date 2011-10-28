<%@include file="/html/init.jsp" %>

<script type="text/javascript">
    function GetKey (event){
        var keyCode = ('which' in event) ? event.which : event.keyCode;
        if(keyCode==13) {
        	document.location.href='/data-and-downloads?searchtext=' + document.getElementById('<%= prefs.getValue(Constants.searchBoxPreferenceName,"searchtext_top") %>').value; 
        	document.getElementById('<%= prefs.getValue(Constants.searchBoxPreferenceName,"searchtext_top") %>').value='';
        }
    }
</script>
<input id="<%= prefs.getValue(Constants.searchBoxPreferenceName,"searchtext_top") %>" name="<%= prefs.getValue(Constants.searchBoxPreferenceName,"searchtext_top") %>" type="text" onkeydown="GetKey(event)" >
&nbsp;<img src="<%= request.getContextPath() %>/images/vergrootglas.png"  onClick="document.location.href='/data-and-downloads?searchtext=' + document.getElementById('<%= prefs.getValue(Constants.searchBoxPreferenceName,"searchtext_top") %>').value; document.getElementById('<%= prefs.getValue(Constants.searchBoxPreferenceName,"searchtext_top") %>').value='';">
