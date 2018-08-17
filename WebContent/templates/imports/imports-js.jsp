<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- jQuery -->
<script src="${rootWeb}/assets/sb_admin_2/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${rootWeb}/assets/sb_admin_2/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="${rootWeb}/assets/sb_admin_2/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="${rootWeb}/assets/sb_admin_2/dist/js/sb-admin-2.js"></script>

<!-- MASCARA -->
<script src="${rootWeb}/assets/jquery_mask_plugin-master/dist/jquery.mask.min.js"></script>

<!-- MODAL (Bootstrap Dialog) -->
<script src="${rootWeb}/assets/dialog/dist/js/bootstrap-dialog.js"></script>

<script type="text/javascript">
	
	$("document").ready(function(){
		
		$(".bloqueado").prop('disabled', true);
		
		$(".obrigatorio").prop('required', 'required').css('border-color', 'orange');
		
		$('.dinheiro').mask('000.000.000.000,00', {
			placeholder : "0,00",
			reverse : true
		});
		
		$('.data').mask('00/00/0000', {
			placeholder : "_//_",
			clearIfNotMatch : true,
			reverse : false
		});

		$('#cpf').mask('000.000.000-00', {
			placeholder : "000.000.000-00",
			clearIfNotMatch : true,
			reverse : false
		});

		$('#cep').mask('00.000-000', {
			placeholder : "00.000-000",
			clearIfNotMatch : true
		});
	});
	
	function validaErros(){
		var msgRetornoDanger = $('.msgRetornoDanger').html();
		var msgRetornoSuccess = $('.msgRetornoSucces').html();
		
		if (typeof msgRetornoDanger != "undefined"){
			BootstrapDialog.show({
				size  : BootstrapDialog.SIZE_LARGE,
				title : 'Atenção',
				message : msgRetornoDanger.trim(),
				closable : true,
				type : BootstrapDialog.TYPE_DANGER,
				buttons:[
					{label : 'OK', 
						action : function(dialogRef){
							dialogRef.close();
						} 
					}
				]
			});
			$('.msgRetornoDanger').html('');
		}
		
		if (typeof msgRetornoSuccess != "undefined"){
			BootstrapDialog.show({
				size  : BootstrapDialog.SIZE_LARGE,
				title : '',
				message : msgRetornoSuccess.trim(),
				closable : true,
				type : BootstrapDialog.TYPE_SUCCESS,
				buttons:[
					{label : 'OK', 
						action : function(dialogRef){
							dialogRef.close();
						} 
					}
				]
			});
			$('.msgRetornoSucces').html('');
		}
	
	}
	
</script>