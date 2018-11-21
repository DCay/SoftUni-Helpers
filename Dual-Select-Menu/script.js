function attachChoiceEvent(choice) {
    $(choice).click(function () {
        if ($(this).hasClass('chosen')) {
            $(this).removeClass('chosen');
            $(this).remove();
            $('#selections').append($(this));
            attachSelectionEvent(this);
            sortMenus($('#selections option'));
        } else {
            $(this).addClass('chosen');
        }
    });
}

function attachSelectionEvent(selection) {
    $(selection).click(function () {
        if ($(this).hasClass('chosen')) {
            $(this).removeClass('chosen');
            $(this).remove();
            $('#choices').append($(this));
            attachChoiceEvent(this);
            sortMenus($('#choices option'));
        } else {
            $(this).addClass('chosen');
        }
    });
}

function sortMenus(elements) {
    let sortArray = [];
    elements.each(function () { sortArray.push($(this).text()) });
    sortArray.sort();
    elements.each(function (index, option) {
        $(option).text(sortArray[index]);
    });
}

$('#choices option').each(function () { attachChoiceEvent(this) });
$('#selections option').each(function () { attachSelectionEvent(this) });