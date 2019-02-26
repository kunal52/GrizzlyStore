<!DOCTYPE html>
<%@page import="com.model.Product"%>
<%@page import="java.util.List"%>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Products</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
    <link href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
    
</head>

<%!
	List<Product>products;
%>
<%products=(List<Product>)request.getAttribute("productlist"); %>


<body>


    <!--     NAVBAR     -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Grizzly Store</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
               
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
            
            <a href="logout"><button type="button" class="btn btn-secondary ml-4">Log Out</button></a>
            
        </div>
    </nav>




    <!-- Profile DIV -->

    <div class="container">
        <div class="row">
            <div class="col-md-3 mt-4 bg-light">


                <nav class="nav navbar-light bg-light">
                    <a class="navbar-brand" href="#">Profile</a>
                    <a class="nav-link" href="#">Edit</a>
                </nav>


                <img src="/images/download.jpg" class="mx-auto d-block mt-4" />

                <h4 class="text-center mt-4">Name</h4>

            </div>

           <div class="col-md-9 mt-4">


                <ul class="nav nav-tabs">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">PRODUCTS</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">VENDORS</a>
                    </li>

                </ul>







                <div class="container visible" id="productslist">


                    <ul class="nav justify-content-end" id="addProductButton">
                        <li class="nav-item">
                            <a class="nav-link" href="#" tabindex="-1" aria-disabled="true">
                                <button onclick="changeProductListToProductAdd()" type="button" class="btn btn-dark">Add Product</button>
                            </a>
                        </li>
                    </ul>


                <table class="table">
                        <thead>
                          <tr>
                            <th scope="col">Products</th>
                            <th scope="col">Category</th>
                            <th scope="col">Price</th>
                            <th scope="col">Rating</th>
                            <th scope="col"></th>
                            <th scope="col"></th>
                            <th scope="col"></th>
                          </tr>
                        </thead>
                        <tbody>
                        
                        <%
                       
                        for(Product p:products)
                        {%>
                        
                          <tr>
                            <th scope="row"><%=p.getName() %></th>
                            <td><%=p.getCategory() %></td>
                            <td><%=p.getPrice() %></td>
                            <td>4.7</td>
                            <th scope="col"><a href="view?id=<%=p.getId()%>"><button type="button" class="btn btn-light">View</button></th></a>
                            <th scope="col"><a href="edit?id=<%=p.getId()%>"><button type="button" class="btn btn-light">Edit</button></th></a>
                            <th scope="col"><a href="remove?id=<%=p.getId()%>"><button type="button" class="btn btn-light">Remove</button></th></a>
                          </tr>
                          <%} %>
                        </tbody>
                      </table>

 </div>


                <div class="container invisible mt-4" id="productAdd">

                    <form action="add" method="get">
                        <div class="form-group">
                            <label for="name">Product Name</label>
                            <input name="name" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter Product Name">
                        </div>
                        <div class="form-group">
                            <label for="productType">Product Type</label>
                            <input name="category" type="text" class="form-control" id="productType" placeholder="Product Type">
                        </div>

                        <div class="form-group">
                            <label for="productType">Product Description</label>
                            <input name="description" type="text" class="form-control" id="productType" placeholder="Product Description">
                        </div>

                        <div class="form-group">
                            <label for="productType">Product Price</label>
                            <input name="price" type="number" class="form-control" id="productType" placeholder="Product Price">
                        </div>

                        <button type="submit" class="btn btn-primary">Add</button>


                    </form>
                    <button onclick="changeProductAddToProductList()" class="btn btn-danger">Cancel</button>
                </div>



            </div>

        </div>
    </div>

    <script>

        function changeProductListToProductAdd() {

            var element1 = document.getElementById("productslist");

            element1.classList.replace("visible", "invisible")

            if (element1.style.display === "none") {
                element1.style.display = "block";
                } else {
                    element1.style.display = "none";
              }


            var element2 = document.getElementById("productAdd");
            element2.classList.replace("invisible", "visible");

        }

        function changeProductAddToProductList() {

            var element1 = document.getElementById("productAdd");

            element1.classList.replace("visible", "invisible")

           


            var element2 = document.getElementById("productslist");
            element2.classList.replace("invisible", "visible");

 if (element2.style.display === "none") {
                element2.style.display = "block";
            } else {
                element2.style.display = "none";
            }

        }
    </script>


</body>

</html>