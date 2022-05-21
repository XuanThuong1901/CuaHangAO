 function getIdDeleteIntoForm(idInput){
	$("a[data-delete]").on("click", function(){
		console.log($(this))
		let id = $(this).data("delete")
		$(`#${idInput}`).attr("value", id)
	})
}

function getIdUpdateIntoForm(idInput){
	$("a[data-delete]").on("click", function(){
		console.log($(this))
		let id = $(this).data("update")
		$(`#${idInput}`).attr("value", id)
	})
}

 
 function activeSidebarItem(){
	 $(".nav-item").each(function() {
		 if($(location).attr("pathname").includes($(this).attr("id"))){
			 $(this).find(".nav-link").addClass("active");
		 }
	 })
 }

function isShowModal(){
	
	let modalShow = $(".modal.fade[isShow=true]");
	
	if(modalShow){
		modalShow.modal('show')
	}
	
}

function onHideModal(myId, myUrl){
	let modalHide = $(".modal.fade[isShow=true]");
	
	if(modalHide){
		modalHide.on('hide.bs.modal', function (event) {
			if(modalHide.attr("id").includes(myId)){

				window.location.href = myUrl;
			}
			
		})
	}
}

function updateAvatar(idInput, idModal){
	 //alertify.notify("Kiểu file ảnh không hợp lệ. Vui lòng chọn ảnh .PNG hoặc .JPG", "success", 7);
	
	 let inpChangeAvatar = $(`#${idInput}`)
	
	 inpChangeAvatar.on("change", function(e){
		 console.log(inpChangeAvatar)
		 let imgAvatar = $(`#${idModal}`)
		 imgAvatar.attr("src", URL.createObjectURL(inpChangeAvatar[0].files[0]))
		 imgAvatar.on("load", function(){
			 URL.revokeObjectURL(imgAvatar.attr("src"))
		 })
	 })
}

function showModalConfirm(idButton, title, ok){
	$(`#${idButton}`).on("click", function(e){
		e.preventDefault();
		alertify.confirm(title, '', function(){
			$(`#${idButton}`).unbind("click")
			$(`#${idButton}`)[0].click()
		}
        , function(){} ).set('labels', {ok:ok, cancel:'Thoát'});

	})
}

$(document).ready(function(){
	activeSidebarItem();
	
	isShowModal();
	
	// modal them
	updateAvatar("input-add-avatar", "modal-add-avatar");
	
	// modal sua
	updateAvatar("input-update-avatar", "modal-update-avatar");
	
	// button them
	showModalConfirm("cancel-save-modal", "Bạn có chắc chắn hủy?", "Hủy");
	
	// button them
	showModalConfirm("cancel-save-modal-phieunhap", "Bạn có chắc chắn hủy?", "Hủy");
	
	// button them
	showModalConfirm("cancel-update-modal-phieunhap", "Bạn có chắc chắn hủy?", "Hủy");
	
	// button sua
	showModalConfirm("cancel-update-modal", "Bạn có chắc chăn hủy?", "Hủy");
	
	// button reset mat khua
	showModalConfirm("btn-reset-mk", "Bạn có chăc chắn muốn reset mật khẩu", "OK");
	
	
	onHideModal("modal-edit-employee", "quanly/nhanvien");
	
	getIdDeleteIntoForm("input-delete-dm");
	
	getIdDeleteIntoForm("input-delete-ncc");
	
	getIdUpdateIntoForm("input-update-hd");
 });