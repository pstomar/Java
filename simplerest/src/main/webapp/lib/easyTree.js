(function ($) {
    $.fn.EasyTree = function (options) {
        var defaults = {
            addable: false,
            i18n: {
                deleteNull: 'Select a node to delete',
                deleteConfirmation: 'Delete this node?',
                confirmButtonLabel: 'Okay',
                editNull: 'Select a node to edit',
                editMultiple: 'Only one node can be edited at one time',
                addMultiple: 'Select a node to add a new node',
                collapseTip: 'collapse',
                expandTip: 'expand',
                selectTip: 'select',
                unselectTip: 'unselect',
                editTip: 'edit',
                addTip: 'add',
                deleteTip: 'delete',
                cancelButtonLabel: 'cancel'
            }
        };

        var warningAlert = $('<div class="alert alert-warning alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><strong></strong><span class="alert-content"></span> </div> ');
        var dangerAlert = $('<div class="alert alert-danger alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><strong></strong><span class="alert-content"></span> </div> ');

        var createInput = $('<div class="input-group"><input type="text" class="form-control"><span class="input-group-btn"><button type="button" class="btn btn-default btn-success confirm"></button> </span><span class="input-group-btn"><button type="button" class="btn btn-default cancel"></button> </span> </div> ');

        options = $.extend(defaults, options);

        this.each(function (){
            var easyTree = $(this);
            $.each($(easyTree).find('ul > li'), function() {
                var text;
                if($(this).is('li:has(ul)')) {
                    var children = $(this).find(' > ul');
                    $(children).remove();
                    text = $(this).text();
                    $(this).html('<span class="parent_li_Span"  style="width:103%;margin-left:-2%;font-size:12px;padding-left:5%;background-color:#283A4E;margin-bottom: -9px;"><span class="glyphicon" style="border:1px solid #152638; padding:3px 5px 3px 5px; background-color:#152638;float:left;"></span><a href="javascript: void(0);" style="padding-left:35px;"></a> </span>');
                    $(this).find(' > span > span').addClass('glyphicon-plus');
                    $(this).find(' > span > a').text(text);
                    $(this).append(children);
                    children.hide('fast');
                }
                else {
                    text = $(this).text();
                    var dataValue = $(this).attr('data-value');
                    var dataType = ($(this).attr('data-type')!=undefined && $(this).attr('data-type')!=null)?$(this).attr('data-type'):"";
                    var className=($(this).attr('class')!=undefined && $(this).attr('class')!=null)?$(this).attr('class'):"";
                    $(this).html('<div class="innerListItem '+className+'" data-value="'+dataValue+'" data-type="'+dataType+'" style="padding-top:7px;"><i class="fa fa-caret-right pull-left" style="margin-top:1px;"></i><a href="javascript: void(0);"><span class="innerListItemText"> </span></a></div>');
                   //$(this).find(' > span > span').addClass('glyphicon-chevron-right');
                    $(this).find(' > div > a > span.innerListItemText').text(text);
                   // $(this).find(' > span > i').addClass('fa fa-caret-right');
                }
            });
            $(easyTree).find('li:has(ul)').addClass('parent_li').find(' > span').attr('title', options.i18n.expandTip);
			$($(easyTree).find('li:has(ul)')).find('ul').addClass('innerListItemUl').addClass('collapsed');
            // add easy tree toolbar dom
            if (options.deletable || options.editable || options.addable) {
                $(easyTree).prepend('<div class="easy-tree-toolbar"></div> ');
            }
            // collapse or expand
            $(easyTree).delegate('li.parent_li > span', 'click', function (e) {
                var children = $(this).parent('li.parent_li').find(' > ul > li');
                if (children.is(':visible')) {
					$(this).parent('li.parent_li').find(' > ul').addClass('collapsed');
					$(this).parent('li.parent_li').find(' > ul').removeClass('expanded');
					$(this).removeClass("expaned-list-item");
                    children.parent().hide();
                    $(this).attr('title', options.i18n.expandTip).find(' > span.glyphicon').addClass('glyphicon-plus').removeClass('glyphicon-minus');
                    $(this).has('.parent_li').css("padding","0px 5px 0px 5px;");
                }else{
					$(this).parent('li.parent_li').find(' > ul').removeClass('collapsed');
					$(this).parent('li.parent_li').find(' > ul').addClass('expanded');
					$(this).addClass("expaned-list-item");
                    children.parent().show('slow');
                    $(this).attr('title', options.i18n.collapseTip).find(' > span.glyphicon').addClass('glyphicon-minus').removeClass('glyphicon-plus');
                    $(this).has('.parent_li').css("padding","10px 5px 0px 5px;");
                }
                e.stopPropagation();
            });

            // selectable, only single select
            if (options.selectable) {
                $(easyTree).find('li > span > a').attr('title', options.i18n.selectTip);
                $(easyTree).find('li > span > a').click(function (e) {
                    var li = $(this).parent().parent();
                    if (li.hasClass('li_selected')) {
                        $(this).attr('title', options.i18n.selectTip);
                        $(li).removeClass('li_selected');
                    }
                    else {
                        $(easyTree).find('li.li_selected').removeClass('li_selected');
                        $(this).attr('title', options.i18n.unselectTip);
                        $(li).addClass('li_selected');
                    }

                    if (options.deletable || options.editable || options.addable) {
                        var selected = getSelectedItems();
                        if (options.editable) {
                            if (selected.length <= 0 || selected.length > 1)
                                $(easyTree).find('.easy-tree-toolbar .edit > button').addClass('disabled');
                            else
                                $(easyTree).find('.easy-tree-toolbar .edit > button').removeClass('disabled');
                        }

                        if (options.deletable) {
                            if (selected.length <= 0 || selected.length > 1)
                                $(easyTree).find('.easy-tree-toolbar .remove > button').addClass('disabled');
                            else
                                $(easyTree).find('.easy-tree-toolbar .remove > button').removeClass('disabled');
                        }

                    }

                    e.stopPropagation();

                });
            }

            // Get selected items
            var getSelectedItems = function () {
                return $(easyTree).find('li.li_selected');
            };
        });
    };
})(jQuery);
