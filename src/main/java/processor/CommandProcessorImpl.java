package processor;

import constants.Commands;
import domain.models.Project;
import services.*;

import java.util.UUID;

public class CommandProcessorImpl implements CommandProcessor {

    private Project project;
    private BoardService boardService;
    private CardService cardService;
    private ListService listService;
    private UserService userService;


    public CommandProcessorImpl(Project project){
        this.project = project;
        this.boardService = new BoardServiceImpl(project);
        this.listService = new ListServiceImpl(project);
        this.cardService = new CardServiceImpl(listService, project);
        this.userService = new UserServiceImpl(project);
    }

    @Override
    public void process(String command) {
        String[] tokens = command.split(" ");
        if(tokens.length == 1 && tokens[0].equalsIgnoreCase("show")){
            boardService.showAllBoards();
        }else if(tokens.length == 3 && tokens[0].equalsIgnoreCase("board")
                && tokens[1].equalsIgnoreCase(Commands.CREATE.getValue())){
            boardService.createBoard(tokens[2]);
        }else if(tokens.length == 3 && tokens[0].equalsIgnoreCase(Commands.SHOW.getValue())
                && tokens[1].equalsIgnoreCase("board")){
            boardService.showBoard(UUID.fromString(tokens[2]));
        }else if(tokens.length == 4 && tokens[0].equalsIgnoreCase("board")){
            boardService.changeAttribute(UUID.fromString(tokens[1]), tokens[2], tokens[3]);
        }else if(tokens.length == 4 && tokens[0].equalsIgnoreCase("board")
                &&tokens[2].equalsIgnoreCase(Commands.ADD_MEMBER.getValue())){
            boardService.addMember(UUID.fromString(tokens[3]), UUID.fromString(tokens[1]));
        }else if(tokens.length == 4 && tokens[0].equalsIgnoreCase("board")
                &&tokens[2].equalsIgnoreCase(Commands.REMOVE_MEMBER.getValue())){
            boardService.removeMember(UUID.fromString(tokens[3]), UUID.fromString(tokens[1]));
        }else if(tokens.length == 4 && tokens[0].equals("list")
                && tokens[1].equalsIgnoreCase(Commands.CREATE.getValue())){
            boardService.addList(tokens[3], UUID.fromString(tokens[2]));
        }else if(tokens.length == 4 && tokens[1].equalsIgnoreCase(Commands.CREATE.getValue())
                && tokens[0].equalsIgnoreCase("card")){
            cardService.create(UUID.fromString(tokens[2]), tokens[3]);
        }else if(tokens.length == 3 && tokens[0].equalsIgnoreCase(Commands.SHOW.getValue())){
            listService.show(UUID.fromString(tokens[2]));
        }else if(tokens.length == 4 && tokens[0].equalsIgnoreCase("card")
                && tokens[2].equalsIgnoreCase(Commands.ASSIGN.getValue())){
            cardService.assign(UUID.fromString(tokens[1]), userService.findByEmail(tokens[3]));
        } else {
            throw new RuntimeException("Illegal command");
        }
    }
}
