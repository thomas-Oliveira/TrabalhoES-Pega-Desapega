<!-- Head BEGIN -->
<div class="main">
	<div class="container">
		<!-- BEGIN SALE PRODUCT & NEW ARRIVALS -->
		<div class="row margin-bottom-40">
			<!-- BEGIN SALE PRODUCT -->
			<div class="col-md-12 col-sm-12 sale-product">
				<h2>${MostraIndex}</h2>
				<div class="owl-carousel owl-carousel5">
					<c:forEach var="c" items="${produtosIndex}">
						<div>
							<div class="product-item">
								<div class="pi-img-wrapper">
									<img src="img/semImagem.png" class="img-responsive"
										alt="${c.getNome()}">
									<div>
										<a href="img/semImagem.png"
											class="btn btn-default fancybox-button">Zoom</a>
									</div>
								</div>
								<h3>
									<a href="/Produto?id=${c.getID()}">${c.getNome()}</a>
								</h3>
								<div class="pi-price">${c.getValor()}</div>
								<c:if test="${Logado}">
									<a href="/Carrinho?id_vendedor=${c.getId_dono()}&id_produto=${c.getID()}" class="btn btn-default add2cart">Add
										carrinho</a>
								</c:if>
								<c:if test="${not Logado}">
									<a href="" onclick="f()" class="btn btn-default add2cart">Add
										carrinho</a>
								</c:if>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-- END SALE PRODUCT -->
		</div>
		<!-- END SALE PRODUCT & NEW ARRIVALS -->
	</div>
</div>

<script src="js/Funcoes.js" type="text/javascript"></script>
