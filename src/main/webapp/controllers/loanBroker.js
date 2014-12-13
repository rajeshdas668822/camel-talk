/**
 * New node file
 */

 angular.module("loanBroker")
.constant("dataUrl","http://localhost:9090/rs/bankQuote")
.controller("bankQouteCntlr",  function ($scope, $http, 
        dataUrl){
	 $scope.griddata = {};
    $scope.sendOrder = function (shippingDetails) {
        var order = angular.copy(shippingDetails);
        //order.products = cart.getProducts();
        $http.post(dataUrl, order)
            .success(function (data) {
            	$scope.griddata=data;
            })
            .error(function (error) {
                $scope.data.orderError = error;
            }).finally(function () {
                $location.path("/complete");
            });
    }
    
    $scope.gridOptions = {
    		data: 'griddata',
    		enableCellSelection: true,
    		enableRowSelection: false,
    		enableCellEdit: true,
    	     columnDefs: [
	    	                {field: 'bankName', displayName: 'Bank', enableCellEdit: true}, 
	    	                {field:'ssn', displayName:'FIN/Passport', enableCellEdit: true},
	    	                {field:'rate', displayName:'Intrest Rate', enableCellEdit: true},	    	                
	    	                {field:'loanAmount', displayName:'Loan Amount', enableCellEdit: true},
	    	                {field:'tenure', displayName:'Tenure', enableCellEdit: true},
	    	                {field:'emi', displayName:'EMI', enableCellEdit: true}   	
    	           ]
    
    };
    jqueryUITheme: true;
});
 