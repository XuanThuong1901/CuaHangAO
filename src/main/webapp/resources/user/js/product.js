$(document).ready(function () {
  $(".btn-filter-size").click(function () {
    $(this).toggleClass("btn-size-active");
  });

  $(".btn-filter-color-item").click(function () {
    $(this).parent().toggleClass("border border-dark");
  });
});
