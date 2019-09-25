<div class="nav-wrapper">
		<div class="container">
			<nav class="navbar navbar-expand-md">
				<a class="navbar-brand" href="back-to-admin-home">ABC Portal</a>
				<button class="navbar-toggler d-lg-none" type="button"
					data-toggle="collapse" data-target="#collapsibleNavId"
					aria-controls="collapsibleNavId" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="nav-bar-light navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavId">
				<form class="form-inline my-2 my-lg-0 justify-content-center" action="search-admin-profile" method="post">
                  <input class="form-control mr-sm-2" type="text" name="search_query" placeholder="Search Profile">
                  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
              </form>
              
					<ul class="navbar-nav ml-auto justify-content-end">
					<li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Admin Functions</a>
                      <div class="dropdown-menu" aria-labelledby="dropdownId">
                          <a class="dropdown-item" href="manage-threads.action?submitType=viewAll">Manage Threads</a>
                          <a class="dropdown-item" href="manage-jobs.action?submitType=fetchAll">Manage Jobs</a>
                          <a class="dropdown-item" href="manage-users.action?submitType=viewAll">Manage Users</a>
                      </div>
                  </li>
						<li class="nav-item"><a class="nav-link"
							href="view-admin-profile">Profile</a></li>
						<li class="nav-item"><a class="nav-link" href="logout-user">Log Out</a>
						</li>
					</ul>
					
				</div>
			</nav>
			
		</div>
	</div>