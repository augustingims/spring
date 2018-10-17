/**
 * Resize function without multiple trigger
 * 
 * Usage: $(window).smartresize(function(){ // code here });
 */

var CURRENT_URL = window.location.href.split('#')[0].split('?')[0], $BODY = $('body'), $MENU_TOGGLE = $('#menu_toggle'), $SIDEBAR_MENU = $('#sidebar-menu'), $SIDEBAR_FOOTER = $('.sidebar-footer'), $LEFT_COL = $('.left_col'), $RIGHT_COL = $('.right_col'), $NAV_MENU = $('.nav_menu'), $FOOTER = $('footer');

// Sidebar
function init_sidebar() {
	// TODO: This is some kind of easy fix, maybe we can improve this
	var setContentHeight = function() {
		// reset height
		$RIGHT_COL.css('min-height', $(window).height());

		var bodyHeight = $BODY.outerHeight(), footerHeight = $BODY
				.hasClass('footer_fixed') ? -10 : $FOOTER.height(), leftColHeight = $LEFT_COL
				.eq(1).height()
				+ $SIDEBAR_FOOTER.height(), contentHeight = bodyHeight < leftColHeight ? leftColHeight
				: bodyHeight;

		// normalize content
		contentHeight -= $NAV_MENU.height() + footerHeight;

		$RIGHT_COL.css('min-height', contentHeight);
	};

	$SIDEBAR_MENU.find('a').on('click', function(ev) {
		console.log('clicked - sidebar_menu');
		var $li = $(this).parent();

		if ($li.is('.active')) {
			$li.removeClass('active active-sm');
			$('ul:first', $li).slideUp(function() {
				setContentHeight();
			});
		} else {
			// prevent closing menu if we are on child menu
			if (!$li.parent().is('.child_menu')) {
				$SIDEBAR_MENU.find('li').removeClass('active active-sm');
				$SIDEBAR_MENU.find('li ul').slideUp();
			} else {
				if ($BODY.is(".nav-sm")) {
					$li.parent().find("li").removeClass("active active-sm");
					$li.parent().find("li ul").slideUp();
				}
			}
			$li.addClass('active');

			$('ul:first', $li).slideDown(function() {
				setContentHeight();
			});
		}
	});

	// toggle small or large menu
	$MENU_TOGGLE.on('click', function() {
		console.log('clicked - menu toggle');

		if ($BODY.hasClass('nav-md')) {
			$SIDEBAR_MENU.find('li.active ul').hide();
			$SIDEBAR_MENU.find('li.active').addClass('active-sm').removeClass(
					'active');
		} else {
			$SIDEBAR_MENU.find('li.active-sm ul').show();
			$SIDEBAR_MENU.find('li.active-sm').addClass('active').removeClass(
					'active-sm');
		}

		$BODY.toggleClass('nav-md nav-sm');

		setContentHeight();

		$('.dataTable').each(function() {
			$(this).dataTable().fnDraw();
		});
	});

	// check active menu
	$SIDEBAR_MENU.find('a[href="' + CURRENT_URL + '"]').parent('li').addClass(
			'current-page');

	$SIDEBAR_MENU.find('a').filter(function() {
		return this.href == CURRENT_URL;
	}).parent('li').addClass('current-page').parents('ul').slideDown(
			function() {
				setContentHeight();
			}).parent().addClass('active');

	setContentHeight();

	// fixed sidebar
	if ($.fn.mCustomScrollbar) {
		$('.menu_fixed').mCustomScrollbar({
			autoHideScrollbar : true,
			theme : 'minimal',
			mouseWheel : {
				preventDefault : true
			}
		});
	}
};
// /Sidebar


// Panel toolbox
$(document)
		.ready(
				function() {
					$('.collapse-link')
							.on(
									'click',
									function() {
										var $BOX_PANEL = $(this).closest(
												'.x_panel'), $ICON = $(this)
												.find('i'), $BOX_CONTENT = $BOX_PANEL
												.find('.x_content');

										// fix for some div with hardcoded fix
										// class
										if ($BOX_PANEL.attr('style')) {
											$BOX_CONTENT
													.slideToggle(
															200,
															function() {
																$BOX_PANEL
																		.removeAttr('style');
															});
										} else {
											$BOX_CONTENT.slideToggle(200);
											$BOX_PANEL.css('height', 'auto');
										}

										$ICON
												.toggleClass('fa-chevron-up fa-chevron-down');
									});

					$('.close-link').click(function() {
						var $BOX_PANEL = $(this).closest('.x_panel');

						$BOX_PANEL.remove();
					});
				});
// /Panel toolbox

// Tooltip
$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip({
		container : 'body'
	});
});
// /Tooltip

// Progressbar
if ($(".progress .progress-bar")[0]) {
	$('.progress .progress-bar').progressbar();
}

// iCheck
$(document).ready(function() {
	if ($("input.flat")[0]) {
		$(document).ready(function() {
			$('input.flat').iCheck({
				checkboxClass : 'icheckbox_flat-green',
				radioClass : 'iradio_flat-green'
			});
		});
	}
});

// Accordion
$(document).ready(function() {
	$(".expand").on("click", function() {
		$(this).next().slideToggle(200);
		$expand = $(this).find(">:first-child");

		if ($expand.text() == "+") {
			$expand.text("-");
		} else {
			$expand.text("+");
		}
	});
});

// NProgress
if (typeof NProgress != 'undefined') {
	// $(document).ready(function() {
	// NProgress.start();
	// });

	// $(window).load(function() {
	// NProgress.done();
	// });

	// $(window).on('load', function(){
	// NProgress.done();
	// });
}

/* PARSLEY */

function init_parsley() {

	if (typeof (parsley) === 'undefined') {
		return;
	}
	console.log('init_parsley');

	$/* .listen */('parsley:field:validate', function() {
		validateFront();
	});
	$('#demo-form .btn').on('click', function() {
		$('#demo-form').parsley().validate();
		validateFront();
	});
	var validateFront = function() {
		if (true === $('#demo-form').parsley().isValid()) {
			$('.bs-callout-info').removeClass('hidden');
			$('.bs-callout-warning').addClass('hidden');
		} else {
			$('.bs-callout-info').addClass('hidden');
			$('.bs-callout-warning').removeClass('hidden');
		}
	};

	$/* .listen */('parsley:field:validate', function() {
		validateFront();
	});
	$('#demo-form2 .btn').on('click', function() {
		$('#demo-form2').parsley().validate();
		validateFront();
	});
	var validateFront = function() {
		if (true === $('#demo-form2').parsley().isValid()) {
			$('.bs-callout-info').removeClass('hidden');
			$('.bs-callout-warning').addClass('hidden');
		} else {
			$('.bs-callout-info').addClass('hidden');
			$('.bs-callout-warning').removeClass('hidden');
		}
	};

	try {
		hljs.initHighlightingOnLoad();
	} catch (err) {
	}

};

/* SELECT2 */

function init_select2() {

	if (typeof (select2) === 'undefined') {
		return;
	}
	console.log('init_toolbox');

	$(".select2_single").select2({
		placeholder : "Select a state",
		allowClear : true
	});
	$(".select2_group").select2({});
	$(".select2_multiple").select2({
		maximumSelectionLength : 4,
		placeholder : "With Max Selection limit 4",
		allowClear : true
	});

};

/* VALIDATOR */

function init_validator() {

	if (typeof (validator) === 'undefined') {
		return;
	}
	console.log('init_validator');

	// initialize the validator function
	validator.message.date = 'not a real date';

	// validate a field on "blur" event, a 'select' on 'change' event & a
	// '.reuired' classed multifield on 'keyup':
	$('form').on('blur', 'input[required], input.optional, select.required',
			validator.checkField).on('change', 'select.required',
			validator.checkField).on('keypress', 'input[required][pattern]',
			validator.keypress);

	$('.multi.required').on('keyup blur', 'input', function() {
		validator.checkField.apply($(this).siblings().last()[0]);
	});

	$('form').submit(function(e) {
		e.preventDefault();
		var submit = true;

		// evaluate the form using generic validaing
		if (!validator.checkAll($(this))) {
			submit = false;
		}

		if (submit)
			this.submit();

		return false;
	});

};

/* PNotify */

function init_PNotify() {

	if (typeof (PNotify) === 'undefined') {
		return;
	}
	console.log('init_PNotify');
};

$(document).ready(function() {

	init_sidebar();
//	init_parsley();
//	init_select2();
//	init_validator();
//	init_PNotify();

});
