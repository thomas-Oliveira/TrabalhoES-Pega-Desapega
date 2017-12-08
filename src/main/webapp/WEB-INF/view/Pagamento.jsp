<div class="container">
	<div class="modal fade" id="Pagamento">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="modal-body">

						<form class="col-md-12 col-lg-12 col-sm-12" method="post"
							action="/ConfirmePagamento" onSubmit="return enviardados();">
							<div class="row">
								<fieldset class="col-md-6">
									<legend>Dados pessoais</legend>
									<div class="form-group">
										<label for="nome">Nome completo</label> ${nome}
									</div>
									<div class="form-group">
										<label for="email">Email</label> ${email}
									</div>
									<div class="form-group">
										<label for="cpf">CPF</label> ${cpf}
									</div>
									<div class="form-group">
										<label for="endereco">Endereço</label> ${endereco}
									</div>
								</fieldset>
								<fieldset class="col-md-6">
									<legend>Cartão de crédito</legend>
									<div class="form-group">
										<label for="numero-cartao">Número</label> <input
											type="text" class="form-control" id="Numero_cartão_credito"
											name="Numero_cartão_credito">
									</div>
									<div class="form-group">
										<label for="numero-cartao">CVV</label> <input
											type="text" class="form-control" id="CVV"
											name="CVV">
									</div>
									<div class="form-group">
										<label for="bandeira-cartao">Bandeira</label> <select
											name="Bandeira" id="Bandeira" class="form-control">
											<option value="master">MasterCard</option>
											<option value="visa">VISA</option>
											<option value="amex">American Express</option>
										</select>
									</div>
									<div class="form-group">
										<label for="validade-cartao">Validade</label> <input
											type="month" class="form-control" id="validade"
											name="validade">
									</div>
								</fieldset>
							</div>
							<button type="submit" class="btn-lg pull-right btn btn-primary">
								<span class="glyphicon	glyphicon-thumbs-up"></span> Confirmar
							</button>
						</form>
					</div>
				</div>
				<div class="modal-footer">
				</div>
			</div>
		</div>
	</div>
</div>

<script src="js/Validação.js"></script>



