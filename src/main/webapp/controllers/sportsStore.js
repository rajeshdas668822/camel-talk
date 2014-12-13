/*angular.module("sportsStore")
.constant("dataUrl", "http://localhost:9090/rs/product")
.controller("sportsStoreCtrl", function ($scope, $http, dataUrl) {

   $http.get(dataUrl)
        .success(function (data) {
            $scope.data.products = data;
        })
        .error(function (error) {
            $scope.data.error = error;
        });
});*/

angular.module("sportsStore")
.constant("dataUrl","http://localhost:9090/rs/product")
.constant("orderUrl","http://localhost:9090/rs/orders")
.controller("sportsStoreCtrl",  function ($scope, $http, $location,
        dataUrl, orderUrl, cart){

    $scope.data = {};
    
    $http.get(dataUrl).success(function (data){
    	$scope.data.products=data;
    }).error(function (error){
    	 $scope.data.error = error;
    });
    		/*products:[{"NAME":"Kayak","DESCRIPTION":"A boat for one person","CATEGORY":"Watersports","PRICE":"275"},
    		 {"NAME":"Lifejacket","DESCRIPTION":"Protective and fashionable","CATEGORY":"Watersports","PRICE":"48.95"},
    		 {"NAME":"Soccer Ball","DESCRIPTION":"FIFA-approved size and weight","CATEGORY":"Soccer","PRICE":"19.5"},
    		 {"NAME":"Corner Flags","DESCRIPTION":"Give your playing field a professional touch","CATEGORY":"Soccer","PRICE":"34.95"},
    		 {"NAME":"Stadium","DESCRIPTION":"Flat-packed 35,000-seat stadium","CATEGORY":"Soccer","PRICE":"79500"},
    		 {"NAME":"Thinking Cap","DESCRIPTION":"Improve your brain efficiency by 75%","CATEGORY":"Chess","PRICE":"16"},
    		 {"NAME":"Unsteady Chair","DESCRIPTION":"secretly give your opponent a disadvantage","CATEGORY":"Chess","PRICE":"29.95"},
    		 {"NAME":"Human Chess Board","DESCRIPTION":"A fun game for the family","CATEGORY":"Chess","PRICE":"75"},
    		 {"NAME":"Bling-Bling King","DESCRIPTION":"Gold-plated, dimond-studded King","CATEGORY":"Chess","PRICE":"1200"}]
    		
    };*/
   
    
    $scope.sendOrder = function (shippingDetails) {
        var order = angular.copy(shippingDetails);
        order.products = cart.getProducts();
        $http.post(orderUrl, order)
            .success(function (data) {
                $scope.data.orderId = data.id;
                cart.getProducts().length = 0;
            })
            .error(function (error) {
                $scope.data.orderError = error;
            }).finally(function () {
                $location.path("/complete");
            });
    }
});


