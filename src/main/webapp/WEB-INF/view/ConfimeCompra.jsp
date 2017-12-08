<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Head BEGIN -->
<head>
<title>Pega&Desapega</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<link rel="shortcut icon" href="favicon.ico">

<!-- Fonts START -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
	rel="stylesheet" type="text/css">
<!--- fonts for slider on the index page -->
<!-- Fonts END -->

<!-- Global styles START -->
<link href="assets/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Global styles END -->

<!-- Page level plugin styles START -->
<link href="assets/pages/css/animate.css" rel="stylesheet">
<link href="assets/plugins/fancybox/source/jquery.fancybox.css"
	rel="stylesheet">
<link href="assets/plugins/owl.carousel/assets/owl.carousel.css"
	rel="stylesheet">
<!-- Page level plugin styles END -->

<!-- Theme styles START -->
<link href="assets/pages/css/components.css" rel="stylesheet">
<link href="assets/pages/css/slider.css" rel="stylesheet">
<link href="assets/pages/css/style-shop.css" rel="stylesheet"
	type="text/css">
<link href="assets/corporate/css/style.css" rel="stylesheet">
<link href="assets/corporate/css/style-responsive.css" rel="stylesheet">
<link href="assets/corporate/css/themes/red.css" rel="stylesheet"
	id="style-color">
<link href="assets/corporate/css/custom.css" rel="stylesheet">
<!-- Theme styles END -->

<!-- CSS -->
<link href="css/Stilo.css" rel="stylesheet">

<style rel="stylesheet" type="text/css" scoped="scoped">
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatarmyconta {
	width: 19%;
	border-radius: 10%;
}
</style>

</head>
<!-- Head END -->

<body class="ecommerce">

	<%@include file="Header.jsp"%>

	<jsp:useBean id="dao"
		class="PegaEDesapega.UsuarioController.UserControllerDao" />

	<div class="container">
		<h3>Compra Confirmada com Sucesso!</h3>
		<br>
	</div>
	<div id="compra">
		<c:forEach var="c" items="${meu_carrinho}">
			<div class="container">
				<div class="container col-md-6" style="background-color: #f1f1f1">
					<h4>
						<center>Dados do Vendedor</center>
					</h4>
					<div class="container content-page col-md-12">
						<label><b>Nome: </b></label>
						${dao.Buscar_Usuario(c.getId_vendedor()).getNome() } <br> <br>
						<label><b>Endereço: </b></label>
						${dao.Buscar_Usuario(c.getId_vendedor()).getEndereco()} <br>
						<br> <label>Email: </label>
						${dao.Buscar_Usuario(c.getId_vendedor()).getEmail()} <br>
					</div>
				</div>

				<div class="container col-md-6" style="background-color: #f1f1f1">
					<h4>
						<center>Detalhes do produto</center>
					</h4>
					<div class="container content-page col-md-12">
						<label><b>Produto: </b></label>${dao.Buscar_Objeto(Long.parseLong(c.getId_Produto())).getNome() }
						<br> <br> <label><b>ID:</b></label> ${c.getId_Produto()}<br>
						<br> <label><b>Valor: </b></label>R$ ${c.getValor()} <br>
					</div>
				</div>
			</div>
		</c:forEach>
		<br>
		<div class="shopping-total container">
			<em>Total</em> <strong class="price"><span>R$</span>${carrinho_valor_total}</strong>
		</div>
	</div>
	<form>
		<input type="button" class="butao" name="imprimir" value="Imprimir"
			onclick="cont();">
	</form>
	<form action="/FinalizarCompra">
		<button class="butao">Finalizar compra</button>
	</form>
	<%@include file="footer.jsp"%>


	<!-- Load javascripts at bottom, this will reduce page load time -->
	<!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
	<!--[if lt IE 9]>
    <script src="assets/plugins/respond.min.js"></script>  
    <![endif]-->
	<script src="assets/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="assets/corporate/scripts/back-to-top.js"
		type="text/javascript"></script>
	<script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
	<script src="assets/plugins/fancybox/source/jquery.fancybox.pack.js"
		type="text/javascript"></script>
	<!-- pop up -->
	<script src="assets/plugins/owl.carousel/owl.carousel.min.js"
		type="text/javascript"></script>
	<!-- slider for products -->
	<script src='assets/plugins/zoom/jquery.zoom.min.js'
		type="text/javascript"></script>
	<!-- product zoom -->
	<script src="assets/plugins/bootstrap-touchspin/bootstrap.touchspin.js"
		type="text/javascript"></script>
	<!-- Quantity -->

	<script src="assets/corporate/scripts/layout.js" type="text/javascript"></script>
	<script src="assets/pages/scripts/bs-carousel.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			Layout.init();
			Layout.initOWL();
			Layout.initImageZoom();
			Layout.initTouchspin();
			Layout.initTwitter();
		});
	</script>
	<!-- END PAGE LEVEL JAVASCRIPTS -->

	<script>
		// Get the modal
		var modal = document.getElementById('id01');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>


	<script>
		function cont() {
			var conteudo = document.getElementById('compra').innerHTML;
			tela_impressao = window.open('about:blank');
			tela_impressao.document.write(conteudo);
			tela_impressao.window.print();
			tela_impressao.window.close();
		}
	</script>



</body>
</html>