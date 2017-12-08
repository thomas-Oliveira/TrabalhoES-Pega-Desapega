<div class="container">
	<div class="modal fade" id="Cadastro">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">

					<h2>Cadastrar usuário</h2>

					<form action="/Cadastro" style="border: 0px solid #ccc" class="formulario">
						
							<label><b>Nome</b></label> <input type="text" class="entrada"
								placeholder="Digite seu nome" name="nome" required> 
								
							<label><b>Email</b></label><input type="text" class="entrada"
							 placeholder="Digite seu email" name="email"required> 
								
							<label><b>Endereço</b></label> <input class="entrada"
								type="text" placeholder="Digite seu endereço" name="endereco"
								required> 
							<label><b>CPF</b></label> <input type="text" class="entrada"
								placeholder="Digite seu CPF" name="cpf" maxlength="11" required>

							<label><b>Senha</b></label> <input type="password" class="entrada"
								placeholder="Digite sua senha" name="Senha" required> 

							<p>
								Ao criar uma conta, você concorda com nossos <a href="#">
									Termos e Privacidade</a>.
							</p>

							<div class="clearfix" >
								<button class="butao" type="submit" class="signupbtn">Criar</button>
							</div>
					
					</form>

				</div>
			</div>
		</div>
	</div>
</div>