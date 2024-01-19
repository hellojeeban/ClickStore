<!-- Modal -->
<div class="modal fade" id="addCategories" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Fill Category
					Details</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form action="addcategory" method="post">
					<div class="from-group">
						<input type="text" class="form-control" name="categoryTitel"
							placeholder="Enter Category Titel" required="required">
					</div>
					<div class="from-group mt-2">
						<textarea style="height: 200px" class="form-control"
							name="categoryDesc" placeholder="Enter Category Description"
							required="required"></textarea>
					</div>
					<div class="modal-footer">
						<div class="container text-center mt-2">
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="reset" class="btn btn-primary">Reset</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>