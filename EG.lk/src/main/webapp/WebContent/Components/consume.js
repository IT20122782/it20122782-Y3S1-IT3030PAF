$(document).on("click", "#btnSave", function(event)
{

 $("#alertSuccess").text(""); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
 
 var status = validateConsumeForm(); 
 if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 } 
 var type = ($("#hidConsumIDSave").val() == "") ? "POST" : "PUT"; 
 $.ajax( 
 { 
 url : "ConsumptionAPI", 
 type : type, 
 data : $("#formCosume").serialize(), 
 dataType : "text", 
 complete : function(response, status) 
 { 
 onConsumeSaveComplete(response.responseText, status); 
 } 
 }); 
});

function onConsumeSaveComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully saved."); 
 $("#alertSuccess").show(); 
 $("#divItemsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while saving."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while saving.."); 
 $("#alertError").show(); 
 }
$("#hidItemIDSave").val(""); 
$("#formItem")[0].reset(); 
}

$(document).on("click", ".btnUpdate", function(event)
{ 
		$("#hidConsumIDSave").val($(this).data("id")); 
		 $("#acc_no").val($(this).closest("tr").find('td:eq(0)').text()); 
		 $("#date").val($(this).closest("tr").find('td:eq(1)').text()); 
		 $("#units").val($(this).closest("tr").find('td:eq(2)').text()); 
		 
		});
		
$(document).on("click", ".btnRemove", function(event)
		{ 
		 $.ajax( 
		 { 
		 url : "ConsumptionAPI", 
		 type : "DELETE", 
		 data : "ID=" + $(this).data("id"),
		 dataType : "text", 
		 complete : function(response, status) 
		 { 
		 onItemDeleteComplete(response.responseText, status); 
		 } 
		 }); 
		});
		
function onConsumeDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divItemsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while deleting."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while deleting.."); 
 $("#alertError").show(); 
 } 
}

function validateConsumeForm()
{
if ($("#acc_no").val().trim() == "")
	{
	return "Insert AccountNo.";
	}
	if ($("#date").val().trim() == "")
	{
	return "Insert Date.";
	}
	if ($("#units").val().trim() == "")
	{
	return "Insert Units.";
	}
	return true;
}
