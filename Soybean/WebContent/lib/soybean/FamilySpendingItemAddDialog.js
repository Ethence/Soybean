/**
 * The Dialog to add a new family spending item
 */
$( "#dialog-form" ).dialog({
    autoOpen: false,
    height: 500,
    width: 350,
    modal: true,
    buttons: {
        "Add": function() {
            $.ajax({
                url: "http://localhost:8080/Soybean/AddFamilySpendingItems",
                type: "post",
                dataType: "text",
                data: {
                    newSpendingDate: $("#newSpendingDate").val(),
                    newSpendingAmount: $("#newSpendingAmount").val(),
                    newSpendingDescription: $("#newSpendingDescription").val(),
                    newSpendingCategory: $("#newSpendingCategory").val(),
                    newSpendingPayMethod: $("#newSpendingPayMethod").val(),
                    newSpendingSpender: $("#newSpendingSpender").val()
                },
                success: function(spendingItems) {
                    console.log(spendingItems);
                    getFamilSpendingItems();
                },
                error: function(xhr, status, errorThrown) {
                    console.log("Errors in getting data from http://localhost:8080/Soybean/AddFamilySpendingItems");
                }
            });
            $( this ).dialog( "close" );
        },
        Cancel: function() {
            $( this ).dialog( "close" );
        }
    },
    close: function() {
        console.log("Closing");
    }
});

$( "#newSpendingDate" ).datepicker();
$( "#date" ).datepicker();
$("#addBtn").button().click(
    function() {
        $( "#dialog-form" ).dialog( "open" );
    }
);

var getFamilSpendingItems = function() {
	$.ajax({
	    url: "http://localhost:8080/Soybean/GetFamilySpendingItems",
	    type: "get",
	    dataType: "json",
	    success: function(spendingItems) {
	        console.log(spendingItems);
	        $.each(spendingItems, function(index, item){
	            jQuery("#spendingTable").jqGrid('addRowData',index+1,item);
	        });
	    },
	    error: function(xhr, status, errorThrown) {
	        console.log("Errors in getting data from http://localhost:8080/Soybean/GetFamilySpendingItems");
	    }
	});
};