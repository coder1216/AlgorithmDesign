// Q3 Design an in-memory file system
// Classes: File, Directory, File System	
// Relationship: Directory contains files or sub directory or empty

// File: chmod 777 744 https://en.wikipedia.org/wiki/Chmod
// Fields:	permission, name, created time, modified time, size, kind, content
// Methods:

// Directory:
// Fields: permission, name, created time, modified time, size, kind, content
// Methods:

// Because many common fields and functionalities between file and directory, so we want to 
// option1: Directory to extend File
// option2: abstract class and extends to Directory File
// option3: interface

// File: permission, name, creation time, modified time, kind, content / size
// Directory: content/size different

// abtract Class Node { // class, abstract class, interface
	
// }

// Class Node {
// 	…
// 	Node parent;
// }


// File:
// String byte[] content; // aligment
// long size;

// Directory:
// List<Node> content
// size → getSize();


abstract class Node {
	name permission parent created modified
	constructor getter setter getSize() getCurrentPath()
}
					root
				node1
			node2
		node3

abstract class Node {
	protected String name;
	protected boolean[] permission;
	protected Node parent;
	protected final Date created;
	protected Date modified;

	protected Node(String n, Node p) {
		name = n;
		parent = p;
		created = System.currentTimeMilis();
	}

	public Date getCreated() {
	return created;
}

	public Date getModified() {
	return modified;
}

public Date setModified(Date time) {
	modified = time;
	return modified;
}

public void reName(String n) {
	name = n;
}
	
	public/protected abstract long getSize(); // // 所有derived class必须实现，并且实现不一样 

	public String getCurrentPath() {
		if (parent == this / null) return "";
		return parent.getCurrentPath() + "/" + name;
	}
}

public class File extends Node {
	private String content;
	private long size;
	
	public File(String name, Node parent, long size, boolean[] pm) {
		super(name, parent);
		this.size = size;
		permission = pm; //protected
}

public String setContent(String content, long size) {
	this.size = size;
	this.content = content;
	return content;
} 

@Override
public long getSize() {
	return size;
}
}

public class Directory extends Node {
	private List<Node> content;

	public Directory(String n, Node p, boolean[] pm) {
		super(n,p);
		permission = pm; //protected
		content = new ArrayList<Node>();
	}

	@Override
	public long getSize() { // 必须实现
		long size = 0;
		for (Node n : children) {
			size += n.getSize(); // recursion return case1 leaf file case2 leaf empty
		}
		return size;
	}

	public void addNode(Node node) {
		content.add(node);
	}
	public void deleteNode(Node node) {
		content.remove(node);
	}

	public int countFiles() {
		int count = 0;
		for (Node child : children) {
			if (child instanceof Directory) {
				Directory d = (Directory) child;
				count += d.countFiles();
			} else {
				count++;
			}
		}
		return count;
	}
}

count += ((Directory)d).filesname();

      {}
Users				Users   **
techbow			techbow       *** ***

Class FileSystem {
	root;

	FileSystem

	mkdir(Sting path)
public void mkdir(String path) { "/Users/techbow/Documents/abc/d/e/f"
		
	}

	createFile(String path)

	cd(String path)

	// delete(String path)

	// count files

	// size
}

public void mkdir(String path) {
	if (path == null || path.length() == 0)
		return null;
	String[] dirs = path.split(“/”);
	Node cur = root;
boolean flag = false;
	for (String dir : dirs) {
		// reset
		for (Node child : cur.getContent()) { // getDirectory()
			if (child.name.equals(dir)) {
				cur = child;
				flag = true;
				break; // must break after chagne cur otherwise, iterator
			}
		} // else
		if (!flag) {
		Node newDir = new Directory(dir, cur);
		child.content.add(newDir);
		cur = newDir;
	}
	}
}
