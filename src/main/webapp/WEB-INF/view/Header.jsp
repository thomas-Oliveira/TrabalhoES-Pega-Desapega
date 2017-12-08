<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <!-- BEGIN TOP BAR -->
  <div class="pre-header">
      <div class="container">
            <div class="row">
                  <!-- BEGIN TOP BAR MENU -->
                  <div class="col-md-12 col-sm-12 additional-nav">
                        <ul class="list-unstyled list-inline pull-right">
                              <c:if test="${Logado}">
                                    <li><a href="/Myaccount">Minha Conta</a></li>
                                    <li><a href="/Logout">Logout</a></li>
                              </c:if>
                              <c:if test="${not Logado}">
                                    <li><a href="#" data-toggle="modal" data-target="#Login">Login</a></li>
                                    <li><a href="#" data-toggle="modal" data-target="#Cadastro">Cadastro</a></li>
                              </c:if>
                        </ul>
                  </div>
            </div>
      </div>
</div>
<!-- END TOP BAR -->

<!-- BEGIN HEADER -->
<div class="header">
      <div class="container">
            <a class="site-logo" href="/"><img src="#" alt="Pega&Desapega"></a>

        <!-- BEGIN CART -->
            <div class="top-cart-block">
                  <div class="top-cart-info">
                        ${carrinho_qtd } itens
                        R$ ${carrinho_valor_total }
                  </div>
                  <a href="/CarrinhoMostrar"><i class="fa fa-shopping-cart"></i></a>
            </div>
<!--END CART -->

<!-- BEGIN NAVIGATION -->
            <div class="header-navigation">
                  <ul>
                        <li class="dropdown dropdown-megamenu">
                              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="">
                                    Produtos
                              </a>
                              <ul class="dropdown-menu">
                                    <li>
                                          <div class="header-navigation-content">
                                                <div class="row">
                                                      <div class="col-md-4 header-navigation-col">
                                                            <a href="/ProcurarCate?Procurar=Veiculo"><h4>Veículos</h4></a>
                                                      </div>
                                                      <div class="col-md-4 header-navigation-col">
                                                            <a href="/ProcurarCate?Procurar=Informatica"><h4>Informática</h4></a>
                                                      </div>
                                                            <div class="col-md-4 header-navigation-col">
                                                                  <a href="/ProcurarCate?Procurar=Casa"><h4>Casa</h4></a>
                                                            </div>
                                                            <div class="col-md-4 header-navigation-col">
                                                            <a href="/ProcurarCate?Procurar=Outros"><h4>Outros</h4></a>
                                                      </div>
                                                </div>
                                          </div>
                                    </li>
                              </ul>
                        </li>

                        <c:if test="${Logado}">
                              <li class="dropdown dropdown100 nav-catalogue">
                                    <a href= "/Mensagens">Mensagens</a>
                              </li>
                        </c:if>

                        <c:if test="${Logado}">
                              <li class="nav-catalogue">
                                    <a data-target="#CadastroProduto" data-toggle="modal" href="">
                                          Cadastrar Produtos
                                    </a>
                              </li>
                        </c:if>


<!-- BEGIN TOP SEARCH -->
                        <li class="menu-search">
                              <form action="/Procurar">
                                    <div class="input-group">
                                          <input type="text" placeholder="Procurar" name="Procurar" class="form-control">
                                          <span class="input-group-btn">
                                                <button class="btn btn-primary" type="submit">Procurar</button>
                                          </span>
                                    </div>
                              </form>
                        </li>
<!-- END TOP SEARCH -->
                  </ul>
            </div>
<!-- END NAVIGATION -->
      </div>
</div>
<!-- Header END -->
<%@include file="Login.jsp"%>
<%@include file="ADDUser.jsp"%>
<%@include file="ProductADD.jsp"%>
