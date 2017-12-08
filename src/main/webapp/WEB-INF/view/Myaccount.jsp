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

</head>
<!-- Head END -->

<body class="ecommerce">

	<%@include file="Header.jsp"%>

	<%@include file="Login.jsp"%>
	<%@include file="ADDUser.jsp"%>

	<h2>
		<center>Meu Perfil</center>
	</h2>

	<div class="container" id="id01">

		<div class="container col-md-12" style="background-color: #f1f1f1">
			<h4>
				<center>Dados Pessoais</center>
			</h4>
		</div>

		<div class="imgcontainer col-sm-6">
			<img src="img/Avatar.png" alt="Avatar" class="avatarmycont">
		</div>

		<div class="container content-page col-md-5">

			<label><b>Nome: </b></label> ${nome}<br> <br> <label><b>CPF:
			</b></label> ${cpf}<br> <br> <label><b>Endereço: </b></label>
			${endereco}
			<div>
				<a
					onclick="document.getElementById('editend').style.display='block'"
					style="width: auto;">Editar</a>
			</div>
			<div id="editend" class="modal_rob container col-md-6">

				<!-- verificar o action-->

				<form action="/AlterarUser" class="modal-content_rob animate"
					class="fomulario">

					<!-- verificar o action-->

					<div class="imgcontainer">
						<label>Atualizar endereço</label> <span
							onclick="document.getElementById('editend').style.display='none'"
							class="close" title="Close modal_rob">×</span><br>
					</div>
					<div class="imgcontainer">
						<input type="text" class="entrada" name="endereco"
							placeholder="Entre com novo endereço" required>
						<button type="submit" class="butao">Atualizar</button>
					</div>
				</form>
			</div>
			<br> <label>Email: </label> ${email}
			<div>
				<a
					onclick="document.getElementById('editemail').style.display='block'"
					style="width: auto;">Editar</a>
			</div>
			<div id="editemail" class="modal_rob container col-md-6">

				<!-- verificar o action-->

				<form action="/AlterarUser" class="modal-content_rob animate"
					class="fomulario">

					<!-- verificar o action-->

					<div class="imgcontainer">
						<label>Atualizar Email</label> <span
							onclick="document.getElementById('editemail').style.display='none'"
							class="close" title="Close modal_rob">×</span><br>
					</div>
					<div class="imgcontainer">
						<input type="text" class="entrada" name="email"
							placeholder="Entre com novo Email" required>
						<button type="submit" class="butao">Atualizar</button>
					</div>
				</form>
			</div>
			<br>

			<div>
				<a
					onclick="document.getElementById('editsenha').style.display='block'"
					style="width: auto;">Redefinir senha</a>
			</div>
			<div id="editsenha" class="modal_rob container col-md-6">

				<!-- verificar o action-->

				<form action="/AlterarUser" class="modal-content_rob animate"
					class="fomulario">

					<!-- verificar o action-->

					<div class="imgcontainer">
						<label>Redefinir nova senha</label> <span
							onclick="document.getElementById('editsenha').style.display='none'"
							class="close" title="Close modal_rob">×</span><br>
					</div>
					<div class="imgcontainer">
						<input class="entrada" type="text" name="senha"
							placeholder="Nova Senha" required>
						<button type="submit" class="butao">Atualizar</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container" id="id02">
		<div class="container col-md-12" style="background-color: #f1f1f1">
			<div class="container col-md-11">
			<h4>
				<center>Meus Produtos</center>
			</h4>
			</div>
			<div class="container col-md-1">
			<a href="/MostrarProdutos" class="btn" style="background-color: #f1f1f1"> <span class="glyphicon glyphicon-refresh"></span></a>
			</div>
		</div>

		<c:forEach var="c" items="${produtos}">
			<div class="imgcontainer col-sm-3">
				<a data-toggle="modal" data-target="#${c.getID()}"> <img
					src="img/semImagem.png" alt="${c.getNome()} imagem" class="avatarmycont">
					<p>${c.getNome()}</p>
				</a>


				<div class="container">
					<div class="modal fade" id="${c.getID()}">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<div class="product-page product-pop-up">
										<div class="row">
											<div class="col-md-6 col-sm-6 col-xs-3">
												<div class="product-main-image">
													<img src="img/semImagem.png" alt="${c.getNome()} Barata">
												</div>
												<div class="product-other-images">
													<a href=""></a> <a href=""></a> <a href=""></a>
												</div>
											</div>
											<div class="col-md-6 col-sm-6 col-xs-9">
												<h2>${c.getNome()}</h2>
												<div>
													<a
														onclick="document.getElementById('${c.getID()}_edittitulo').style.display='block'"
														style="width: auto;">Editar</a>
												</div>
												<div id="${c.getID()}_edittitulo"
													class="modal_rob container col-md-6">

													<!-- verificar o action-->

													<form action="/AlterarObjr"
														class="modal-content_rob animate" class="formulario">

														<!-- verificar o action-->

														<div class="imgcontainer">
															<label>Editar Título do Produto</label> <span
																onclick="document.getElementById('${c.getID()}_edittitulo').style.display='none'"
																class="close" title="Close modal_rob">×</span><br>
														</div>
														<div class="imgcontainer">
															<input type="text" name="nome" class="entrada"
																placeholder="Novo Título" required>
															<button type="submit" value="${c.getID()}" name="id" class="butao">Atualizar</button>
														</div>
													</form>
												</div>

												<div class="price-availability-block clearfix"
													align="center">
													<div class="price">
														<br> <strong><span>R$</span>${c.getValor()}</strong>
														<div>
															<a
																onclick="document.getElementById('${c.getID()}_editpreco').style.display='block'"
																style="width: auto;">Editar</a>
														</div>
														<div id="${c.getID()}_editpreco"
															class="modal_rob container col-md-6">

															<!-- verificar o action-->

															<form action="/AlterarObjr"
																class="modal-content_rob animate" class="formulario">

																<!-- verificar o action-->

																<div class="imgcontainer">
																	<label>Editar Preço do Produto</label> <span
																		onclick="document.getElementById('${c.getID()}_editpreco').style.display='none'"
																		class="close" title="Close modal_rob">×</span><br>
																</div>
																<div class="imgcontainer">
																	<input type="text" name="Valor" class="entrada"
																		placeholder="Novo Preço em R$" required>
																	<button type="submit" value="${c.getID()}" name="id" class="butao">Atualizar</button>
																</div>
															</form>
														</div>
													</div>
												</div>
												<div class="deion">

													<p>${c.getDescricao()}</p>

													<div>
														<a
															onclick="document.getElementById('${c.getID()}_editdescr').style.display='block'"
															style="width: auto;">Editar</a>
													</div>
													<div id="${c.getID()}_editdescr"
														class="modal_rob container col-md-6">

														<!-- verificar o action-->

														<form action="/AlterarObjr"
															class="modal-content_rob animate" class="formulario">

															<!-- verificar o action-->

															<div class="imgcontainer">
																<label>Editar Descrições do Produto</label> <span
																	onclick="document.getElementById('${c.getID()}_editdescr').style.display='none'"
																	class="close" title="Close modal_rob">×</span><br>
															</div>
															<div class="imgcontainer">
																<form class="formulario">
																	<textarea name="Descricao" rows="4" cols="50"></textarea>
																	<br>
																</form>
																<button type="submit" value="${c.getID()}" name="id" class="butao">Atualizar</button>
															</div>
														</form>
													</div>
												</div>
												<div class="product-page-cart">
													<br>
													<form id="RmvProdForm" action="/Remover" >
														<button id="RmvBut" class="btn btn-primary butao FormBotao" onclick="return confirm('Enviar formulário?');" value="${c.getID()}" name="id" type="submit">Remover
														Produto</button></form>

												</div>
											</div>
											<div class="sticker sticker-sale"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>



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
		var modal = document.getElementById('id02');
		var modal = document.getElementById('editend');
		var modal = document.getElementById('editemail');
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

</body>
</html>