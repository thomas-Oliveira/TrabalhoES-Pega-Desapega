<div class="container">
	<div class="modal fade" id="CadastroProduto">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">

					<h2>Cadastro de produto</h2>

					<form action="/AddObj" style="border: 0px solid #ccc">

						<label><b>Nome</b></label> <input type="text" class="entrada"
							placeholder="Nome do produto" name="Nome" required> <label><b>Descrição</b></label>
						<input type="text" class="entrada"
							placeholder="Descrição do produto" name="Descricao" required>

						<label><b>Valor R$</b></label> <input type="number"
							class="entrada" placeholder="Valor do produto" name="Valor"
							required> <label><b>Categoria</b></label> <select
							name="Categoria" class="selectpicker">
							<option>Selecione a categoria</option>
							<option value="Veiculo">Veículo</option>
							<option value="Informatica">Informática</option>
							<option value="Casa">Casa</option>
							<option value="Outros">Outros</option>
						</select>

						<div class="modal-footer">
							<button type="submit" class="butao">Cadastrar produto</button>
						</div>

					</form>

				</div>
			</div>
		</div>
	</div>
</div>
