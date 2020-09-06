$(document).ready(function() {
	
	/**
	 *  Prevent the default form submit
	 *  No handlers required. Updates applied in the global Ajax success handler
	 */
	$("#optionsForm").on('submit', function(e) {
	    e.preventDefault();
	    
	    $(this).ajaxSubmit({
    	    success: function(data, status, xhr) {
    	    	console.log("Succesfully submitted update request.");
    	    },
	   	    error: function() {
	   	    	 aler("Error");
	   	    }
	    })
	});
	
	/**
	 * Setup the initial UIConfig status. 
	 * Cannot fetch headers in JS on page load however could read from a hidden element in the page
	 * or could make an initial AJax call to load the initial configuration.
	 */
	var uiConfigJson = $("#initialUIConfigHolder").text();
	$("#initialUIConfigHolder").remove(); //no longer required
	var initialUIConfig = JSON.parse(uiConfigJson);
	console.log("Fetched initial UI config as: " + initialUIConfig);
	
	/**
	 * Initialise the knockout mappings. This will automatically create
	 * observable properties from each of the properties in the loaded UIConfig.
	 */
	var viewModel = ko.mapping.fromJS(initialUIConfig);
	
	/**
	 * On first page load we can have knockout update the UI. Not sure
	 * on performance of that. We could then render UI server side based on 
	 * current UI config and only have knockout update subsequently
	 * i.e. we defer ko.applyBindings(viewModel); to after the first update.
	 */
 	var firstUpdate = true;
 	
	
	/**
	 * Attach a JQuery Ajax event Listener
	 * 
	 * This will intercept and execute on the successful completion of any Ajax
	 * call. Here we can check if the UIConfig header is returned in the response
	 * and if so have knockout automatically update the UI in response to
	 * the latest header values 
	 * 
	 */
	$(document).ajaxSuccess(
		function(event, xhr) {
			console.log("Ajax success handler triggered");
		
			//check for the UIConfig header
			var uiConfigHeader = xhr.getResponseHeader("uiConfig");
		
			if (uiConfigHeader) {
				console.log("UI Config header found with value:"
						+ uiConfigHeader
						+ " Updating the View Model");
				
				//convert to a JS Object
				var updatedUIConfig = JSON.parse(uiConfigHeader);
				
				//update the knockout properties from the retrieved UI configuration
				ko.mapping.fromJS(updatedUIConfig, viewModel);
				
				if(firstUpdate){
					firstUpdate = false;
				 	ko.applyBindings(viewModel);
				}
			}
	});
});