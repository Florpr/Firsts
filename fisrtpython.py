def add_task_to_list(task: str, todo_list: list, position: int=None):
    """Adds a task to the to-do list at the specified position"""
    if position is None:
        todo_list.append(task)  # Add to the end if no position is specified
    elif position < 1 or position > len(todo_list) + 1:  # Corrected syntax: no colon (:) after elif
        raise IndexError(f"{position} is an invalid position for to do list of size {len(todo_list)}")
    else:
        todo_list.insert(position - 1, task)  # Insert the task at the given position

def remove_task_from_list(position: int, todo_list: list):
    """Removes a task from the to-do list at the specified position"""
    if position < 1 or position > len(todo_list):
        raise IndexError(f"{position} is an invalid position for to do list of size {len(todo_list)}")
    else:
        todo_list.pop(position - 1)  # Remove the task

def move_task(position1: int, position2: int, todo_list: list):
    """Moves a task from one position to another in the to-do list"""
    if position1 < 1 or position1 > len(todo_list):  # Verifica si position1 es válida
        raise IndexError(f"{position1} is an invalid position 1 for to do list of size {len(todo_list)}")
    elif position2 < 1 or position2 > len(todo_list):  # Verifica si position2 es válida
        raise IndexError(f"{position2} is an invalid position 2 for to do list of size {len(todo_list)}")
    else:
        task = todo_list.pop(position1 - 1)
        todo_list.insert(position2 - 1, task)  # Mueve la tarea

def move_task_to_other_list(position1: int, todo_list1: list, todo_list2: list, position2: int=None):
    """Moves a task from one list to another at a specified position"""
    if position1 < 1 or position1 > len(todo_list1):
        pass  # Handle invalid position in the first list
    else:
        task = todo_list1.pop(position1 - 1)  # Remove the task from todo_list1 with correct indexing
        if position2 is None:
            todo_list2.append(task)  # Add to the end of todo_list2 if no position is given
        elif position2 < 1 or position2 > len(todo_list2) + 1:
            pass  # Handle invalid position in the second list
        else:
            todo_list2.insert(position2 - 1, task)  # Insert at the given position in todo_list2 with correct indexing

def get_task(position: int, todo_list: list):
    """Gets the task at the specified position"""
    if position < 1 or position > len(todo_list):
        pass  # Handle invalid position
    else:
        return todo_list[position - 1]  # Return the task at the given position


def show_list(todo_list: list):
    """Prints the content of the todo list in this format:
    _____________________
    | 1. Item1          |
    | 2. Item2          |
    | 3. Item3          |
    | 4. Item4          |
    | ...               |
    _____________________
    Parameters:
    todo_list: List with tasks
    """
    print("_"*34)
    for pos, task in enumerate(todo_list, start=1):
        task = str(pos) + ". " + task
        if len(task) > 30:
            task_str1 = task[:29]
            task_str2 = task[29:]
            while len(task_str2) > 30:
                print(f"| {task_str1}- |")
                task_str1 = task_str2[:29]
                task_str2 = task_str2[29:]
            print(f"| {task_str1}- |")
            wspace = " "*(30 - len(task_str2))
            print(f"| {task_str2}{wspace} |")
        else:
            wspace = " "*(30 - len(task))
            print(f"| {task}{wspace} |")
    print("_"*34)
